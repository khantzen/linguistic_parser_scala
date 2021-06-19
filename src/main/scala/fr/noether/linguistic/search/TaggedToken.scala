package fr.noether.linguistic.search

import fr.noether.linguistic.search.PosTag.PosTag

case class TaggedToken(token: Token, posTag: PosTag) {
  def tokenValue(): String = token.value

}
