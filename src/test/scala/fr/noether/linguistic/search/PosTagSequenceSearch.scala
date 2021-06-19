package fr.noether.linguistic.search

import org.scalatest.funsuite.AnyFunSuite

class PosTagSequenceSearch extends AnyFunSuite {

  test("Should find a unique sequence of given PosTag") {
    val sentence  = Sentence.of(Seq(
      TaggedToken(Token("Bilbo"), PosTag.PROPN),
      TaggedToken(Token("was"), PosTag.AUX),
      TaggedToken(Token("ninety"), PosTag.NUM),
      TaggedToken(Token("-"), PosTag.PUNCT),
      TaggedToken(Token("nine"), PosTag.NUM)
    ))

    val matcher = Matcher.of(Seq(PosTag.PROPN, PosTag.AUX))

    val searchResult = matcher.applyOn(sentence)

    assert(searchResult == Seq("Bilbo was"))
  }

  test("Should find both occurrences of a given postag sequence") {
    // talk and excitement
    val sentence = Sentence.of(Seq(
      TaggedToken(Token("Talk"), PosTag.NOUN),
      TaggedToken(Token("and"), PosTag.CCONJ),
      TaggedToken(Token("excitement"), PosTag.NOUN),
      TaggedToken(Token("are"), PosTag.AUX),
      TaggedToken(Token("cabbages"), PosTag.NOUN),
      TaggedToken(Token("and"), PosTag.CCONJ),
      TaggedToken(Token("potatoes"), PosTag.NOUN),
    ))

    val matcher = Matcher.of(Seq(PosTag.NOUN, PosTag.CCONJ, PosTag.NOUN))

    val searchResult = matcher.applyOn(sentence)

    assert(searchResult == Seq("Talk and excitement", "cabbages and potatoes"))
  }



}
