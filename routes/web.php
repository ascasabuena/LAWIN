<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});

//Hardware
Route::get('/reports/getAll', 'ReportsController@getAllReports');
Route::get('/reports/{id}', 'ReportsController@getCoordinates');
Route::get('/reports/{phone_no}/{lat}/{lng}', 'ReportsController@setCoordinates');

//users
Route::post('/users','UsersController@setUser');
Route::post('/users/login','UsersController@login');
Route::get('/verify/{username}', 'UsersController@verifyUser');

//devices
Route::post('/devices','DevicesController@setDevice');
Route::get('/devices/{id}','DevicesController@getPhone');

//devices master
Route::post('/devicemaster','DeviceMasterController@setDeviceMaster');
Route::get('/devicemaster/{id}','DeviceMasterController@getDeviceMaster'); //not sure
