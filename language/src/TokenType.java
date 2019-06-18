package language.src;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * An instance represents a Token with a category and a string representation.
 */
public enum TokenType {
   OR(TokenCategory.OTHER, "or"),
   AND(TokenCategory.OTHER, "and"),
   LT(TokenCategory.RELOP, "<"),
   LE(TokenCategory.RELOP, "<="),
   EQ(TokenCategory.RELOP, "="),
   GE(TokenCategory.RELOP, ">="),
   GT(TokenCategory.RELOP, ">"),
   NE(TokenCategory.RELOP, "!="),
   PLUS(TokenCategory.ADDOP, "+"),
   MINUS(TokenCategory.ADDOP, "-"),
   MUL(TokenCategory.MULOP, "*"),
   DIV(TokenCategory.MULOP, "/"),
   MOD(TokenCategory.MULOP, "%"),
   ASSIGN(TokenCategory.OTHER, ":="),
   LBRACKET(TokenCategory.OTHER, "["),
   RBRACKET(TokenCategory.OTHER, "]"),
   LPAREN(TokenCategory.OTHER, "("),
   RPAREN(TokenCategory.OTHER, ")"),
   LBRACE(TokenCategory.OTHER, "{"),
   RBRACE(TokenCategory.OTHER, "}"),
   IF(TokenCategory.OTHER, "if"),
   THEN(TokenCategory.OTHER, "then"),
   SEMICOLON(TokenCategory.OTHER, ";"),
   COLON(TokenCategory.ADDOP.OTHER, ":"),
   NUM(TokenCategory.OTHER, "<number>"),
   ERROR(TokenCategory.OTHER, "[error]"),
   EOF(TokenCategory.OTHER, "EOF");

   /** Maps the string representation of a token to its enum. */
   private static final Map<String, TokenType> stringToTypeMap;

   // static initializer to initialize the values of stringToTypeMap
   static {
      final Map<String, TokenType> temp = new HashMap<>();
      for (TokenType t : TokenType.values()) {
         temp.put(t.stringRep, t);
      }
      stringToTypeMap = Collections.unmodifiableMap(temp);
   }

   /** The category of this TokenType. */
   private final TokenCategory category;

   /** String representation of this TokenType. */
   private final String stringRep;

   /**
    * Constructs a new {@code TokenType} with category {@code cat} and string
    * representation {@code s}.
    * 
    * @param tcat
    *           token category, checks {@code tcat != null}
    * @param s
    *           string representation of this token, check {@code s != null}
    */
   private TokenType(TokenCategory tcat, String s) {
      assert tcat != null : "TokenType must have a category";
      assert s != null : "TokenType must have a string representation";
      category = tcat;
      stringRep = s;
   }

   /**
    * Returns this {@code TokenType}'s category.
    * 
    * @return this {@code TokenType}'s category
    */
   public TokenCategory category() {
      return category;
   }

   /**
    * Returns the {@code TokenType} that is represented by the string
    * {@code rep}.
    * 
    * @param rep
    *           the string representing the {@code TokenType}, checks
    *           {@code rep} indeed represents a valid {@code TokenType}
    * @return the {@code TokenType} represented by the string {@code rep}
    */
   public static TokenType getTypeFromString(String rep) {
      return stringToTypeMap.get(rep);
   }

   @Override
   public String toString() {
      return stringRep;
   }
}
