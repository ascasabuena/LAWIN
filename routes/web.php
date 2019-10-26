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
Route::get('/reports/{id}', 'ReportsController@getCoordinates');
Route::post('/reports', 'ReportsController@setCoordinates');

//users
Route::post('/users','UsersController@setUser');
Route::get('/verify/{username}', 'UsersController@verifyUser');
