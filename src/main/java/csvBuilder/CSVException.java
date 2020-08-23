package csvBuilder;

public class CSVException extends Exception {

   public enum ExceptionType {
      WRONG_HEADER_OR_WRONG_DELIMITER_OR_WRONG_FILE_TYPE, CENSUS_FILE_PROBLEM, FILE_CAN_NOT_PARSE
   }

   private ExceptionType type;

   public CSVException(String message, ExceptionType type) {
      super(message);
      this.type = type;
   }

   public CSVException(String message, ExceptionType type, Throwable cause) {
      super(message, cause);
      this.type = type;
   }
}
