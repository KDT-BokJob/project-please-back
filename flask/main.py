from dotenv import dotenv_values
from flask import Flask, request, jsonify
from flask import render_template

from src.db.db import get_filtered_recruit_id

app = Flask(__name__)
config = dotenv_values(".flaskenv")


@app.errorhandler(404)
def not_found(error):
    return render_template('error.html', error='{}'.format(404)), 404


@app.route("/")
def hello_world():
    return '<h1>{}</h1>'.format(__name__)


@app.route('/hello/')
@app.route('/hello/<name>')
def hello(name=None):
    return render_template('hello.html', name=name, FLASK_RUN_PORT=config["FLASK_RUN_PORT"],
                           SPRING_RUN_PORT=config["SPRING_RUN_PORT"])


@app.route('/fetch/example')
def api():
    return render_template('base.html')


@app.route('/echo/<param>')
def get_echo_call(param):
    return jsonify({"param": param})


@app.route('/echo', methods=['POST'])
def post_echo_call():
    param = request.get_json()
    return jsonify(param)


@app.route('/join', methods=['GET'])
def get_join():
    query = request.args.get('query')
    data = {'status_code': 400, 'method': request.method, 'query': query}
    return jsonify(data)


@app.route('/recruit/filter', methods=['GET'])
def get_filtered_recruit():
    arguments = request.args
    df = get_filtered_recruit_id(arguments);
    # print(arguments)
    return jsonify({"args": request.args, "data": df.to_dict('records')})


if __name__ == '__main__':
    app.run(debug=True)
