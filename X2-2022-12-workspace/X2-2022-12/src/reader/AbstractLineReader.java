package reader;

import java.io.IOException;
import java.util.List;

abstract public class AbstractLineReader<T> {
    private String dataLabel;

    protected AbstractLineReader(String dataLabel){
        this.dataLabel = dataLabel;
    }

    public List<T> read(String filename) throws IOException{
        
    }

    abstract protected T getElementFromLine(String line);
}
