package fr.noether.linguistic.search

object PosTag extends Enumeration {
  protected case class Val(symbol: String, partOfSpeech: String) extends super.Val {}

  type PosTag = Val


  val DET: Val = Val("DET", "Determinant")

  val NOUN: Val = Val("NOUN", "Noun")
  val PROPN: Val = Val("PROPN", "Proper Noun")
  val AUX: Val  = Val("AUX", "Auxiliary")
  val NUM: Val = Val("NUM", "Number")
  val PUNCT: Val = Val("PUNCT", "Punctuation")
  val CCONJ: Val = Val("CCONJ", "coordinating conjunction")

}

/*
* object Operator extends Enumeration {
  protected case class Val(symbol: String, operation: (Int, Int) => Int) extends super.Val {
    def applyOn(x: Int, y: Int) = operation.apply(x, y)

  }

  implicit  def valueToOperation(x: Value): notation.Operator.Operator = x.asInstanceOf[Val]

  type Operator = Val

  val sum: Val = Val("+", (x,y) => x + y)
  val product: Val = Val("x", (x,y) => x * y)
  val subtract: Val = Val("-", (x, y) => x - y)

  def bySymbol(symbol: String): Operator = Operator.values.find(_.symbol == symbol).get
  def isOperatorSymbol(symbol: String): Boolean = !Operator.values.filter(_.symbol == symbol).isEmpty

}
*
* */