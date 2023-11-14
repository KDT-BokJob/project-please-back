def reverse(reversal: list, answers: dict, shift: int):
    for i in reversal:
        answers[i] = shift - answers[i]
    return answers


def domains_scores(domains_questions: dict, answers: dict):
    scores = {}
    for domain in domains_questions:
        single_domain_scores = [answers[i] for i in domains_questions[domain]]
        scores[domain] = sum(single_domain_scores) / len(single_domain_scores)
    return scores
