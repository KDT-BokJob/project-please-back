from flask import Flask
from dotenv import dotenv_values
from flask import render_template

app = Flask(__name__)
config = dotenv_values(".flaskenv")


@app.route("/")
def hello_world():
    return '<h1>{}</h1>'.format(__name__)


@app.route('/hello/')
@app.route('/hello/<name>')
def hello(name=None):
    return render_template(
        'hello.html',
        name=name,
        FLASK_RUN_PORT=config["FLASK_RUN_PORT"],
        SPRING_RUN_PORT=config["SPRING_RUN_PORT"])


if __name__ == '__main__':
    app.run()
