package fr.noether.linguistic.search

import fr.noether.linguistic.search.PosTag.PosTag

case class PosTagReader(headIndex: Int, postagPattern: Seq[PosTag], matchedToken: Seq[Token] = Seq()) {
  def validated(): Boolean = headIndex == postagPattern.size

  def sentence(): String = matchedToken.map(it => it.value).mkString(" ")

  def iterReader(currentToken: TaggedToken): PosTagReader =
    PosTagReader(
      headIndex + 1,
      postagPattern,
      matchedToken :+ currentToken.token
    )

  def matchWith(currentToken: TaggedToken): Boolean = currentToken.posTag == postagPattern(headIndex)


}
