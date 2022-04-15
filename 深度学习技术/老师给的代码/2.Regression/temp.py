# coding:utf-8

import numpy as np
import pandas as pd
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import accuracy_score
from sklearn.model_selection import train_test_split
from sklearn.model_selection import GridSearchCV

if __name__ == '__main__':
    data = pd.read_csv('iris.data', header=None)
    data[4] = pd.Categorical(data[4]).codes
    x = data[[0,1,2,3]]
    y = data[4]
    x_train, x_test, y_train, y_test = train_test_split(x, y, train_size=0.7, random_state=1)
    C_candidates = np.logspace(-3, 3, 20)
    # model = LogisticRegressionCV(Cs=C_candidates, penalty='l2')
    lr = LogisticRegression(penalty='l2')
    model = GridSearchCV(lr, param_grid={'C':C_candidates}, cv=5)
    model.fit(x_train, y_train)
    print '最优参数：', model.best_params_
    y_train_pred = model.predict(x_train)
    print '训练集准确率：', accuracy_score(y_train, y_train_pred)
    y_test_pred = model.predict(x_test)
    print '测试集准确率：', accuracy_score(y_test, y_test_pred)
