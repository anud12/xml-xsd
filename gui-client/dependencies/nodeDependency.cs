using System;
using System.Diagnostics;
using System.Threading;
using dataStore;
using Godot;

namespace Dependencies
{

    public class NodeDependency
    {
        private static string ExecutableRelativePath = "dependencies_bin" + System.IO.Path.DirectorySeparatorChar + "node" + System.IO.Path.DirectorySeparatorChar + "windows" + System.IO.Path.DirectorySeparatorChar + "gui_client_node.exe";
        private static string ScriptRelativePath =  "dependencies_bin/node/bundle.js";
        public static DataStore<bool> isRunning = new DataStore<bool>(false);
        public static DataStore<Process> process = new DataStore<Process>(null);

        public static void ReadFromOs() {
            // Read if a process named gui_client_node is running
            Process[] processes = Process.GetProcessesByName("gui_client_node");
            if (processes.Length > 0) {
                isRunning.data = true;
                process.data = processes[0];
            } else {
                isRunning.data = false;
                process.data = null;
            }
        }
        public static void Close()
        {
            if (process.data != null)
            {
                process.data.Kill();
                process.data = null;
            }
        }

        public static void Start()
        {
            try {
                // Create a new process instance
                Process process = new Process();

                // Configure the process start info
                process.StartInfo.FileName = ExecutableRelativePath;
                process.StartInfo.Arguments = ScriptRelativePath;
                process.StartInfo.UseShellExecute = false;
                // process.StartInfo.RedirectStandardOutput = true;
                // process.StartInfo.RedirectStandardError = true;

                // Register the event handler for process exit
                process.Exited += new EventHandler((sender, e) =>
                {
                    isRunning.data = false;
                    NodeDependency.process.data = null;
                });
                process.EnableRaisingEvents = true;

                // Start the process
                process.Start();
                NodeDependency.process.data = process;
                isRunning.data = true;
                // Optionally, read the output
                // string output = process.StandardOutput.ReadToEnd();
                // string error = process.StandardError.ReadToEnd();

                // Wait for the process to exit
                // process.WaitForExit();
            } catch (Exception e) {
                isRunning.data = false;
                NodeDependency.process.data = null;
                throw e;
            }
        }
    }
}