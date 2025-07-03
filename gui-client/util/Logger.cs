using System;
using System.Runtime.CompilerServices;
using Godot;

namespace Guiclient.util;

public class Logger
{
    public static void Info(dynamic message,
        [CallerMemberName] string member = "",
        [CallerFilePath] string file = "",
        [CallerLineNumber] int line = 0)
    {
        var thread = System.Threading.Thread.CurrentThread;
        GD.Print($"[Thread:{thread.ManagedThreadId} {thread.Name}] {file}:line {line} - {member}() - {message.ToString()}");
    }

    public static void Error(dynamic message,
        [CallerMemberName] string member = "",
        [CallerFilePath] string file = "",
        [CallerLineNumber] int line = 0)
    {
        var thread = System.Threading.Thread.CurrentThread;
        GD.PrintErr($"[Thread:{thread.ManagedThreadId} {thread.Name}] {file}:line {line} - {member}() - {message.ToString()}");
    }

    public static void Warn(string message,
        
        [CallerMemberName] string member = "",
        [CallerFilePath] string file = "",
        [CallerLineNumber] int line = 0)
    {
        var thread = System.Threading.Thread.CurrentThread;
        GD.PrintErr($"[Thread:{thread.ManagedThreadId} {thread.Name}] {file}:line {line} - {member}() - {message.ToString()}");
    }
}