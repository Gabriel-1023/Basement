# coding:utf-8

import numpy as np
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression, Ridge
from sklearn.metrics import r2_score, mean_squared_error, mean_absolute_error
from sklearn.model_selection import GridSearchCV
import matplotlib.pyplot as plt

if __name__ == '__main__':
    data = pd.read_csv('Advertising.csv', header=0)
    print data
    x = data[['TV', 'Radio']]
    y = data['Sales']

    # titles = 'TV', 'Radio', 'Newspaper'
    # for i in range(1,4):
    #     xx = data.iloc[:, i]
    #     plt.subplot(3, 1, i)
    #     plt.plot(xx, y, 'ro', ms=7)
    #     plt.grid()
    #     plt.title(titles[i-1])
    # plt.show()
    # print data.iloc[:, 1]
    x_train, x_test, y_train, y_test = train_test_split(x, y, train_size=0.7, random_state=0)
    # model = LinearRegression(fit_intercept=True)
    ridge = Ridge(fit_intercept=True)
    model = GridSearchCV(ridge, param_grid={'alpha':np.logspace(-3, 3, 10)})
    model.fit(x_train, y_train)
    print '最优参数：', model.best_params_
    y_train_pred = model.predict(x_train)
    y_test_pred = model.predict(x_test)
    print '训练集R2：', r2_score(y_train, y_train_pred)
    mse_train = mean_squared_error(y_train, y_train_pred)
    print '训练集MSE和RMSE：', mse_train, np.sqrt(mse_train)
    mae_train = mean_absolute_error(y_train, y_train_pred)
    print '训练集MAE：', mae_train

    print '测试集R2：', r2_score(y_test, y_test_pred)
    mse_test = mean_squared_error(y_test, y_test_pred)
    print '测试集MSE和RMSE：', mse_test, np.sqrt(mse_test)
    mae_test = mean_absolute_error(y_test, y_test_pred)
    print '测试集MAE：', mae_test
