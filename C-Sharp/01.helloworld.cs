// System is System Namespace where lots of deafaul classes are defined
using System;

// Define New Namespace for project
namespace HelloWorld
{
  // Define new Class
  class Program
  {
    // Main function need to be static, since it won't be called by class object
    static void Main(string[] args)
    {
      // Console is defined in System Namespace and provides ReadLine and WriteLine methods
      Console.WriteLine("Hello World!");    
    }
  }
}