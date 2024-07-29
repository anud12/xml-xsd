using System;
using System.Diagnostics;
using System.IO;
using System.Xml;
using Godot;
using XSD;

public class ImplProgram {
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