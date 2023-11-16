from pprint import pprint

import numpy as np
import pandas as pd

from src.HEXACO.calc import reverse, domains_scores
from src.HEXACO.model import reversal, domains_questions
from src.Recommendation.similarity import find_similarity
from src.db.db import get_valid_recruit_id_by_user_ids


def calc_result(answers_file):
    answers = pd.read_csv(answers_file, index_col=0).squeeze("rows").to_dict()
    answers = {int(k): v for k, v in answers.items()}
    answers = reverse(reversal, answers, 6)

    return domains_scores(domains_questions, answers)


def recommendation(user_id, max_recommendation=5, similarity_threshold=0.5):
    user_id_similarity_dict = find_similarity(user_id, similarity_threshold)
    df = get_valid_recruit_id_by_user_ids(user_id_similarity_dict)

    if user_id_similarity_dict is None:
        return "no recruit data found by applying history of similar users"
    print(f"{user_id_similarity_dict=}")

    df["priority"] = df.apply(lambda x: user_id_similarity_dict.get(x.user_id), axis=1)
    return df[:max_recommendation]


pprint(recommendation(4, 2, 0.5))
