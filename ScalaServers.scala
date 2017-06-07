import java.net._
import java.io._
import scala.io._
object ScalaServers extends App
{
    try
    {
       val server = new ServerSocket(19999)
       println("Initialized a server:")
       val client = server.accept

       val in = new BufferedReader(new InputStreamReader(client.getInputStream)).readLine
       val out = new PrintStream(client.getOutputStream)

       println("Server received:" + in)
       out.println("Message received")
       out.flush

       if (in.equals("Disconnect")) client.close; server.close; println("Server is now closing")
    }

    catch
    {
       case e: Exception => println(e.getStackTrace); System.exit(1)
    }
}
