package org.pentaho.di.core.logging;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Level;
import org.apache.log4j.spi.LoggingEvent;

import com.xforceplus.apollo.logger.ApolloLoggerFactory;

public class AliyunlogAppender extends AppenderSkeleton {
    
    @Override
    public void close() {
       close();
    }

    @Override
    public boolean requiresLayout() {
        return false;
    }

    @Override
    protected void append(LoggingEvent event) {
       if(event.getMessage()==null){
            return;
        }
       
        String message = event.getRenderedMessage();//JacksonUtil.getInstance().toJson(event.getRenderedMessage());
        
        switch (event.getLevel().toInt()) {
            case Level.ERROR_INT:
                ApolloLoggerFactory.getFactory().loggerError(message);
                break;
             case Level.WARN_INT:
                 ApolloLoggerFactory.getFactory().loggerWarn(message);         
                break;
             case Level.INFO_INT:
                 ApolloLoggerFactory.getFactory().loggerInfo(message);         
                 break;
             case Level.DEBUG_INT:
                 ApolloLoggerFactory.getFactory().loggerDebug(message);         
                 break;
             case Level.TRACE_INT:
                 ApolloLoggerFactory.getFactory().loggerDebug(message);         
                 break;
            default:
                break;
        }

    }

}
