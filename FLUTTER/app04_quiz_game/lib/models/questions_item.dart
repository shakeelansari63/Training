class QuestionItem {
  const QuestionItem({required this.question, required this.answers});

  final String question;
  final List<String> answers;

  List<String> getShuffledAnswers() {
    var shuffledAnswers = List.of(answers);
    shuffledAnswers.shuffle();

    return shuffledAnswers;
  }
}
