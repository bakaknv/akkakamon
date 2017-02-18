package naklugin.perduction;


import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import kamon.Kamon;
import kamon.jmx.JMXReporter;
import kamon.jmx.JMXReporterActor;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ActorSystem system = ActorSystem.create("test");

        Kamon.start();
        ActorRef testActor = system.actorOf(Props.create(MyPerduction.class), "testActor");

        for (int i = 0; i < 1000; i++)
        {
            testActor.tell("test", system.lookupRoot());
        }
    }
}
