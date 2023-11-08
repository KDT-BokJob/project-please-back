import pandas as pd

from src.HEXACO.model import reversal, domains_questions


def calc_result(answers_file):
    answers = pd.read_csv(
        answers_file,
        index_col=0,
    ).squeeze("rows").to_dict()
    answers = {int(k): v for k, v in answers.items()}
    answers = reverse(reversal, answers, 6)

    return domains_scores(domains_questions, answers)


def asd():
    return "asd"
