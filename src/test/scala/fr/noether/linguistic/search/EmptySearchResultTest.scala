package fr.noether.linguistic.search

import org.scalatest.funsuite.AnyFunSuite

class EmptySearchResultTest extends AnyFunSuite {

  test("Should return empty list when searching for nothing in empty sentence") {
    val sentence = Sentence.empty()
    val matcher = Matcher.empty()

    val searchResult = matcher.applyOn(sentence)

    assert(searchResult.isEmpty)
  }

  test("Should return empty list when searching for any postag in empty sentence") {
    val sentence = Sentence.empty()
    val matcher = Matcher.of(PosTag.DET)
    val searchResult = matcher.applyOn(sentence)

    assert(searchResult.isEmpty)
  }

}
