using System;
using System.Diagnostics;
using System.Threading;
using util.dataStore;
using Godot;
using Guiclient.util;

namespace Dependencies
{

    public class NodeDependency
    {
        private static string ExecutableRelativePath = "dependencies_bin" + System.IO.Path.DirectorySeparatorChar + "node" + System.IO.Path.DirectorySeparatorChar + "windows" + System.IO.Path.DirectorySeparatorChar + "gui_client_node.exe";
        private static string ScriptRelativePath = "dependencies_bin/node/bundle.js";
        public static DataStore<bool> isRunning = new DataStore<bool>(false);
        public static DataStore<Process> process = new DataStore<Process>(null);

        public static void ReadFromOs()
        {
            // Read if a process named gui_client_node is running
            Process[] processes = Process.GetProcessesByName("gui_client_node");
            
            //redirect standard output and standard error of process to be read by the application
            


            if (processes.Length > 0)
            {
                var runningProcess = processes[0];

                isRunning.data = true;
                runningProcess.EnableRaisingEvents = true;
                process.data = runningProcess;
                runningProcess.Exited += new EventHandler((sender, e) =>
                {
                    Console.WriteLine("nodeDependency Exited");
                    isRunning.data = false;
                    NodeDependency.process.data = null;
                });
            }
            else
            {
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
            try
            {
                // Create a new process instance
                Process process = new Process();

                // Configure the process start info
                process.StartInfo.FileName = ExecutableRelativePath;
                process.StartInfo.Arguments = ScriptRelativePath;
                process.StartInfo.UseShellExecute = false;
                process.StartInfo.RedirectStandardOutput = true;
                process.StartInfo.RedirectStandardError = true;

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

                //thread to read from standard output
                new Thread(() =>
                {
                    while (process.HasExited == false)
                    {
                        Logger.Info("nodeDependency: " + process.StandardOutput.ReadLine());
                    }
                }).Start();
                //thread to read from standard error
                new Thread(() =>
                {
                    while (process.HasExited == false)
                    {
                        Logger.Info("nodeDependency [Error]: " + process.StandardError.ReadLine());
                    }
                }).Start();

                isRunning.data = true;
                // Optionally, read the output
                // string output = process.StandardOutput.ReadToEnd();
                // string error = process.StandardError.ReadToEnd();

                // Wait for the process to exit
                // process.WaitForExit();
            }
            catch (Exception e)
            {
                isRunning.data = false;
                NodeDependency.process.data = null;
                throw e;
            }
        }
    }
}