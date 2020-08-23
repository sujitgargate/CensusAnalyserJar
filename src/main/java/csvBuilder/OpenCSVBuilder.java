package csvBuilder;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public class OpenCSVBuilder<E> implements ICSVBuilder {
   @Override
   public Iterator<E> getCSVFileIterator(Reader reader, Class csvClass) throws CSVException {
      return this.getCSVBean(reader,csvClass).iterator();
   }

   @Override
   public List getCSVList(Reader reader, Class csvClass) throws CSVException {
      return this.getCSVBean(reader,csvClass).parse();
   }

   private CsvToBean<E> getCSVBean(Reader reader, Class csvClass) throws CSVException {
      try {
         CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder(reader);
         csvToBeanBuilder.withType(csvClass);
         csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
         return csvToBeanBuilder.build();
      } catch (IllegalStateException e) {
         throw new CSVException(e.getMessage(), CSVException.ExceptionType.FILE_CAN_NOT_PARSE);
      }
   }
}
