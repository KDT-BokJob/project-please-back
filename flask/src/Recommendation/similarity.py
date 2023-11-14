import numpy as np

from src.Recommendation.preprocessing import preprocessing
from src.db.db import get_user_df


def cos_sim(A, B):
    return np.dot(A, B) / (np.linalg.norm(A) * np.linalg.norm(B))


def find_similarity(user_id, threshold=0.5):
    # print(f"{user_id=}")
    df = preprocessing(get_user_df())

    str_expr = f"user_id == {user_id}"
    print(f"{str_expr=}")

    res = {}
    df_q = df.query(str_expr)
    if len(df_q) < 1: return None
    print(df_q.index)

    df.drop(df_q.index, inplace=True)

    # arr_std_id = np.array(df_q)[0][0]
    arr_std_content = np.array(df_q)[0][1:]

    for record in np.array(df):
        arr_compared_id = np.array(record)[0]
        arr_compared_content = np.array(record)[1:]
        res[arr_compared_id] = cos_sim(arr_std_content, arr_compared_content)

    res_over_threshold = {}
    for e in res.items():
        if e[1] >= threshold:
            res_over_threshold[e[0]] = e[1]

    sorted_result = sorted(res_over_threshold.items(), key=lambda item: item[1], reverse=True)
    return dict(sorted_result)

