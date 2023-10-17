from flask import Flask
from dotenv import dotenv_values

app = Flask(__name__)
config = dotenv_values("env/.flaskenv")


@app.route("/")
def hello_world():
    return ('<a href="http://localhost:{}">Next</a><br>'.format(config["NEXT_RUN_PORT"]) +
            '<a href="http://localhost:{}">Django</a><br>'.format(config["FLASK_RUN_PORT"]) +
            '<a href="http://localhost:{}">Spring</a>'.format(config["SPRING_RUN_PORT"]))


app.run()
