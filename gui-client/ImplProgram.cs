using System;
using System.Diagnostics;
using System.IO;
using System.Net.Http;
using System.Net.WebSockets;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Xml;
using Godot;
using XSD;

public class ImplProgram
{

    static public Task<String> SendHttp(world_step worldStep) {
        return Task.Run(() =>
        {
            var document = new XmlDocument();
            XmlElement worldStepElement = document.CreateElement("world_step");
            document.AppendChild(worldStepElement);
            GD.Print("Serializing world step");
            worldStep.Serialize(worldStepElement);

            // Deserialize document to string
            var stringWriter = new StringWriter();
            var xmlTextWriter = new XmlTextWriter(stringWriter);
            document.WriteTo(xmlTextWriter);
            xmlTextWriter.Flush();
            var documentString = stringWriter.GetStringBuilder().ToString();

            // Save the document string to a file
            using (StreamWriter sw = new StreamWriter("request.xml"))
            {
                document.Save(sw);
            }

            // Send the document string to the server
            using (var client = new System.Net.Http.HttpClient())
            {
                var content = new StringContent(documentString, Encoding.UTF8, "text/xml");
                var response = client.PostAsync("http://localhost:8080/analyze/execute", content).Result;
                var responseString = response.Content.ReadAsStringAsync().Result;
                GD.Print(responseString);
                //write the received message to a file
                using (StreamWriter sw = new StreamWriter("response.xml"))
                {
                    //format xml file
                    XmlDocument responseDocument = new XmlDocument();
                    responseDocument.LoadXml(responseString);
                    responseDocument.Save(sw);
                }

                return responseString;
            }
        });
    }

    static public Task<String?> SendWebsocket(world_step worldStep)
    {
        return Task.Run(() =>
        {
            var document = new XmlDocument();
            XmlElement worldStepElement = document.CreateElement("world_step");
            document.AppendChild(worldStepElement);
            GD.Print("Serializing world step");
            worldStep.Serialize(worldStepElement);

            // Deserialize document to string
            var stringWriter = new StringWriter();
            var xmlTextWriter = new XmlTextWriter(stringWriter);
            document.WriteTo(xmlTextWriter);
            xmlTextWriter.Flush();
            var documentString = stringWriter.GetStringBuilder().ToString();

            // Save the document string to a file
            using (StreamWriter sw = new StreamWriter("request.xml"))
            {
                document.Save(sw);
            }
            using (ClientWebSocket ws = new ClientWebSocket())
            {
                Uri serverUri = new Uri("ws://localhost:8080");
                try
                {
                    ws.ConnectAsync(serverUri, CancellationToken.None).Wait();
                }
                catch (AggregateException e)
                {
                    e.InnerException.Equals(new WebSocketException("Unable to connect to the remote server"));
                    GD.PrintErr("Unable to connect to the remote server");
                    return null;
                }
                GD.Print("Connected to the server");



                // Send the document string to the server
                var bytesToSend = Encoding.UTF8.GetBytes(documentString);
                GD.Print($"Sending");
                ws.SendAsync(new ArraySegment<byte>(bytesToSend), WebSocketMessageType.Text, true, CancellationToken.None).Wait();

                // Read all contents from the WebSocket
                string receivedMessageTask = ReceiveMessagesAsync(ws, bytesToSend.Length);
                string receivedMessage = receivedMessageTask;
                GD.Print($"Received");

                //write the received message to a file
                using (StreamWriter sw = new StreamWriter("response.xml"))
                {
                    sw.Write(receivedMessage);
                }

                ws.CloseAsync(WebSocketCloseStatus.NormalClosure, "Closing", CancellationToken.None).Wait();
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
        do
        {
            var resultTask = webSocket.ReceiveAsync(new ArraySegment<byte>(buffer), CancellationToken.None);
            result = resultTask.Result;

            var messageChunk = Encoding.UTF8.GetString(buffer, 0, result.Count);
            completeMessage.Append(messageChunk);

            if (result.EndOfMessage)
            {
            }
        } while (!result.EndOfMessage);
        return completeMessage.ToString();
    }

    static public void Main(world_step worldStep)
    {

        //create if not exist the file out.xml
        if (!File.Exists("request.xml"))
        {
            File.Create("request.xml").Close();
        }
        using (StreamWriter sw = new StreamWriter("request.xml"))
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