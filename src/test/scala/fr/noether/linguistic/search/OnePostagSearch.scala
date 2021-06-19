package fr.noether.linguistic.search

import org.scalatest.funsuite.AnyFunSuite

class OnePostagSearch extends AnyFunSuite {

  test("Should return the token matching the given postag") {
    val sentence = Sentence.of(Seq(TaggedToken(Token("The"), PosTag.DET)))
    val matcher = Matcher.of(PosTag.DET)

    val searchResult = matcher.applyOn(sentence)

    assert(searchResult.nonEmpty)
    assert(searchResult == Seq("The"))
  }

  test("Should return all the occurrence of a given postag in a sentence") {
    val sentence  = Sentence.of(Seq(
      TaggedToken(Token("Bilbo"), PosTag.PROPN),
      TaggedToken(Token("was"), PosTag.AUX),
      TaggedToken(Token("ninety"), PosTag.NUM),
      TaggedToken(Token("-"), PosTag.PUNCT),
      TaggedToken(Token("nine"), PosTag.NUM)
    ))

    val matcher = Matcher.of(PosTag.NUM)
    val searchResult = matcher.applyOn(sentence)
    assert(searchResult == Seq("ninety", "nine"))
  }

  test("Should return all the occurrence of a given postag in a sentence 2") {
    val sentence  = Sentence.of(Seq(
      TaggedToken(Token("talk"), PosTag.NOUN),
      TaggedToken(Token("and"), PosTag.CCONJ),
      TaggedToken(Token("excitement"), PosTag.NOUN)
    ))

    val matcher = Matcher.of(PosTag.NOUN)
    val searchResult = matcher.applyOn(sentence)
    assert(searchResult == Seq("talk", "excitement"))
  }

}
