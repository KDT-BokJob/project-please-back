import pandas as pd

from src.HEXACO.model import reversal, domains_questions
from src.db.db import get_user_df

from pprint import pprint


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
    res = get_user_df()

    print(user_id)

    return res


def EDA(df):
    pprint(df.keys())

    for key in df.keys():
        ls = df[key].unique()
        if len(ls) < 20:
            print(f"{key}:{len(ls)} {ls}")
    # print(df.info)
    print(df[:3].T)


def preprocessing(df):
    nums = ['age', 'period', 'korean_proficiency', 'day_remains', 'total_day_worked', 'total_indicators',
            'is_experienced', 'is_disabled']
    cats = ['address', 'gender', 'nationality', 'visa']

    # one-hot-encoding
    for key in cats:
        dum = pd.get_dummies(df[key], prefix=key)
        df = pd.concat([df, dum], axis='columns')
        df.pop(key)

    # normalize
    for key in nums:
        mn, mx = df[key].min(), df[key].max()
    df[key].apply(lambda x: (x - mn) / (mx - mn))
    return df


user_df = get_user_df()
# EDA(user_df)
user_df = preprocessing(user_df)
print(user_df[:3].T)
