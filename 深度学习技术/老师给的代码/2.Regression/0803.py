# coding:utf-8

import numpy as np
import pandas as pd
import matplotlib as mpl
import matplotlib.pyplot as plt
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression, RidgeCV
from sklearn.metrics import mean_squared_error, mean_absolute_error

if __name__ == '__main__':
    data = pd.read_csv('Advertising.csv', header=0)
    print data
    x = data[['TV', 'Radio', 'Newspaper']]
    y = data['Sales']
    x_train, x_test, y_train, y_test = train_test_split(x, y, train_size=0.7, random_state=0)
    # model = LinearRegression(fit_intercept=True)
    model = RidgeCV(alphas=np.logspace(-5, 5, 11), fit_intercept=True, cv=5)
    model.fit(x_train, y_train)
    print '超参数：', model.alpha_
    print '模型参数：', model.coef_, model.intercept_
    y_train_pred = model.predict(x_train)
    mse_train = mean_squared_error(y_train, y_train_pred)
    print '训练集MSE/RMSE', mse_train, np.sqrt(mse_train)
    mae_train = mean_absolute_error(y_train, y_train_pred)
    print '训练集MAE', mae_train

    y_test_pred = model.predict(x_test)
    mse_test = mean_squared_error(y_test, y_test_pred)
    print '测试集MSE/RMSE：', mse_test, np.sqrt(mse_test)
    mae_test = mean_absolute_error(y_test, y_test_pred)
    print '测试集MAE', mae_test

    err = y_train - y_train_pred
    plt.hist(err, bins=20, color='g', alpha=0.7)
    plt.show()
