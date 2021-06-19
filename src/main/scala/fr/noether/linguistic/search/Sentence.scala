package fr.noether.linguistic.search

import fr.noether.linguistic.search.PosTag.PosTag

case class Sentence(taggedTokens: Seq[TaggedToken]) {
  def initTextReader(): TextReader = TextReader(0, taggedTokens)

  def tokenWith(postag: PosTag): Seq[TaggedToken] =
    taggedTokens.filter(taggedToken => taggedToken.posTag == postag)

}

object Sentence {
  def of(taggedTokens: Seq[TaggedToken]): Sentence = Sentence(taggedTokens)
  def empty() : Sentence = Sentence(Seq())
}
