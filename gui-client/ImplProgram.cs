using System;
using System.Diagnostics;
using System.IO;
using System.Net.WebSockets;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Xml;
using Godot;
using XSD;

public class ImplProgram {

    static public Task<String> Send(world_step worldStep)
    {
        return Task.Run(async () =>
        {
            using (ClientWebSocket ws = new ClientWebSocket())
            {
                Uri serverUri = new Uri("ws://localhost:8080");
                await ws.ConnectAsync(serverUri, CancellationToken.None);
                GD.Print("Connected to the server");

                var document = new XmlDocument();
                XmlElement worldStepElement = document.CreateElement("world_step");
                document.AppendChild(worldStepElement);
                worldStep.Serialize(worldStepElement);

                // Deserialize document to string
                var stringWriter = new StringWriter();
                var xmlTextWriter = new XmlTextWriter(stringWriter);
                document.WriteTo(xmlTextWriter);
                xmlTextWriter.Flush();
                var documentString = stringWriter.GetStringBuilder().ToString();

                // Send the document string to the server
                var bytesToSend = Encoding.UTF8.GetBytes(documentString);
                ws.SendAsync(new ArraySegment<byte>(bytesToSend), WebSocketMessageType.Text, true, CancellationToken.None);

                // Read all contents from the WebSocket
                string receivedMessageTask = ReceiveMessagesAsync(ws, bytesToSend.Length);
                string receivedMessage = receivedMessageTask;
                GD.Print($"Received: {receivedMessage}");

                ws.CloseAsync(WebSocketCloseStatus.NormalClosure, "Closing", CancellationToken.None);
                GD.Print("Connection closed");
                return receivedMessage;
            }
        });
    }


        private static String ReceiveMessagesAsync(ClientWebSocket webSocket, long chunkSize)
        {
            var buffer = new byte[1];
            var completeMessage = new StringBuilder();
            WebSocketReceiveResult result;
            do {
                var resultTask = webSocket.ReceiveAsync(new ArraySegment<byte>(buffer), CancellationToken.None);
                result = resultTask.Result;
                
                var messageChunk = Encoding.UTF8.GetString(buffer, 0, result.Count);
                completeMessage.Append(messageChunk);

                if (result.EndOfMessage)
                {
                    Console.WriteLine($"Received complete message: {completeMessage}");

                    // completeMessage.Clear(); // Clear the StringBuilder for the next message
                }
            } while (!result.EndOfMessage);
            return completeMessage.ToString();
        }
    
    static public void Main(world_step worldStep)
    {

        //create if not exist the file out.xml
		if (!File.Exists("out.xml"))
		{
			File.Create("out.xml").Close();
		}
		//open file out.xml
		using (StreamWriter sw = new StreamWriter("out.xml"))
		{
			var document = new XmlDocument();
            XmlElement worldStepElement = document.CreateElement("world_step");
            document.AppendChild(worldStepElement);
			worldStep.Serialize(worldStepElement);
			document.Save(sw);
		}

        // Specify the process start information
        ProcessStartInfo startInfo = new ProcessStartInfo
        {
            WorkingDirectory = "../impl", // Replace with the working directory you want to use
            
            // FileName = "npm run start -- ../gui-client/" + fileName, // Replace with the program you want to call
            FileName = "cmd.exe", // Replace with the program you want to call
            Arguments = "/c npm run start -- ../gui-client/out.xml", // Replace with the arguments you want to pass
            RedirectStandardOutput = true,
            RedirectStandardError = true,
            UseShellExecute = false,
            CreateNoWindow = true
        };

        // Start the process
        using (Process process = new Process())
        {
            process.StartInfo = startInfo;
            process.Start();

            // Read the standard output
            string output = process.StandardOutput.ReadToEnd();

            // Read the standard error
            string error = process.StandardError.ReadToEnd();

            // Wait for the process to exit
            process.WaitForExit();


            // Print the output to the console
            GD.Print(output);

            // Print the error to the console
            GD.PrintErr(error);
        }
    }
}