from pprint import pprint

import pandas as pd


def eda(df):
    pprint(df.keys())

    for key in df.keys():
        ls = df[key].unique()
        if len(ls) < 20:
            print(f"{key}:{len(ls)} {ls}")
    print(df.info())
    print(df[:3].T)


def preprocessing(df):
    # eda(df)
    str_type = ['address', 'gender', 'nationality', 'visa']
    float_type = ['age']
    int_type = ['period', 'korean_proficiency', 'day_remains', 'total_day_worked', 'total_indicators']
    bool_type = ['is_experienced', 'is_disabled']

    for key in str_type:
        df[key] = df[key].astype(str)
    for key in float_type:
        df[key] = df[key].astype(str).astype(float)
    for key in int_type:
        df[key] = df[key].astype(str).astype(int)

    nums = float_type + int_type + bool_type
    cats = str_type

    # one-hot-encoding
    for key in cats:
        dum = pd.get_dummies(df[key], prefix=key)
        df = pd.concat([df, dum], axis='columns')
        df.pop(key)

    # filter
    df = df[(19 <= df['age'])]
    df = df[(df['age'] < 60)]

    # normalize
    for key in nums:
        mn, mx = df[key].min(), df[key].max()
        if mn < mx and key not in bool_type:
            df[key] = df[key].apply(lambda x: (x - mn) / (mx - mn))

    return df
