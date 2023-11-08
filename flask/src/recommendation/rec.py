import pandas as pd

from src.HEXACO.model import reversal, domains_questions
from src.db.db import get_user_df







def reverse(reversal: list, answers: dict, shift: int):
    """TODO: Docstring for reverse.

    :reversal: TODO
    :answers: TODO
    :shift: maximum score + 1
    :returns: TODO

    """
    for i in reversal:
        answers[i] = shift - answers[i]
    return answers


def domains_scores(domains_questions: dict, answers: dict):
    """TODO: Docstring for domains_scores.

    :domains_questions: TODO
    :answers: TODO
    :returns: TODO

    """
    scores = {}
    for domain in domains_questions:
        single_domain_scores = [answers[i] for i in domains_questions[domain]]
        scores[domain] = sum(single_domain_scores) / len(single_domain_scores)
    return scores


def calc_result(answers_file):
    answers = pd.read_csv(
        answers_file,
        index_col=0,
    ).squeeze("rows").to_dict()
    answers = {int(k): v for k, v in answers.items()}
    answers = reverse(reversal, answers, 6)

    return domains_scores(domains_questions, answers)


def find_similarity(user_id):
    return get_user_df()
