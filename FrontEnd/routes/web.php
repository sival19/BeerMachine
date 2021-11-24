<?php

use App\Http\Controllers\Controller;
use App\Http\Controllers\ProductionController;
use Illuminate\Support\Facades\Route;

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

Route::get('/', [Controller::class, 'production_index'])->name('home');
Route::get('/show_productions', [ProductionController::class, 'show_productions'])->name('show_productions-link');
Route::get('/show_production', [ProductionController::class, 'show_production'])->name('show_production-link');
Route::get('/show_Current_Production', [ProductionController::class, 'showCurrentProduction'])->name('production.current');
Route::get('/show_Start_Production', [ProductionController::class, 'startProduction'])->name('production.start');

