package csvBuilder;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public interface ICSVBuilder<E> {
   public Iterator<E> getCSVFileIterator(Reader reader, Class csvClass) throws CSVException;
   public List getCSVList(Reader reader, Class csvClass) throws CSVException;

}

