package fr.noether.linguistic.search

import fr.noether.linguistic.search.PosTag.PosTag

trait Matcher {
  def applyOn(sentence: Sentence): Seq[String]
}

case class EmptyMatcher() extends Matcher {
  override def applyOn(sentence: Sentence) = Seq()
}

case class SinglePosTagMatcher(postag: PosTag) extends Matcher {
  def applyOn(sentence: Sentence): Seq[String] =
    sentence
      .tokenWith(postag)
      .map(it => it.tokenValue())
}

case class PosTagSequenceMatcher(postagPattern: Seq[PosTag]) extends Matcher {

  def initPostagReader(): PosTagReader = PosTagReader(0, postagPattern)

  override def applyOn(sentence: Sentence): Seq[String] = {
    var textReader = sentence.initTextReader()

    var validatedPostagReader: Seq[PosTagReader] = Seq()
    var posTagReaderList: Seq[PosTagReader] = Seq()

    textReader.foreach(it => {
      posTagReaderList = posTagReaderList :+ initPostagReader()

      posTagReaderList = posTagReaderList
        .filter(posTagReader => posTagReader.matchWith(it))
        .map(posTagReader => posTagReader.iterReader(it))

      val validatedPostag = posTagReaderList.filter(posTagReader => posTagReader.validated())
      validatedPostagReader = validatedPostagReader ++: validatedPostag

      posTagReaderList = posTagReaderList
        .filter(posTagReader => !posTagReader.validated())
    })

    validatedPostagReader
      .map(it => it.sentence())
  }
}

object Matcher {
  def of(postag: PosTag): Matcher = SinglePosTagMatcher(postag)
  def of(postag: Seq[PosTag]): Matcher = PosTagSequenceMatcher(postag)
  def empty() : Matcher = EmptyMatcher()
}

