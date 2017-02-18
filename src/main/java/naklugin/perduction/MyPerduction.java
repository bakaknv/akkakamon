package naklugin.perduction;


import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;


/**
 * Created by nkalugin on 17.02.17.
 */
class MyPerduction extends UntypedActor
{
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    @Override
    public void preStart() {
        log.debug("Starting");
    }


    public void onReceive(Object message) {
        if (message.equals("test")) {
            log.info("Received test");
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ignored)
            {

            }
        } else {
            log.warning("Received unknown message: {}", message);
        }
    }
}
