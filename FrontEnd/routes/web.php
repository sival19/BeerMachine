<?php

use App\Events\abortButton;
use App\Events\clearButton;
use App\Events\readState;
use App\Events\resetButton;
use App\Events\startProdEvent;
use App\Events\stopButton;
use App\Http\Controllers\Controller;
use App\Http\Controllers\MachineController;
use App\Http\Controllers\OeeController;
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



Route::get('/show_productions', [ProductionController::class, 'show_productions'])->name('show_productions-link');
Route::get('/show_productions/{show_production}', [ProductionController::class, 'show_production'])->name('show_production-link');
Route::get('/', [ProductionController::class, 'startProduction'])->name('production.start');
Route::get('/oee', [OeeController::class, 'oee'])->name('oee');


Route::get('/getProductions', [ProductionController::class, 'getProductions'])->name('getProductions');

Route::get('/getState', [ProductionController::class, 'getState'])->name('machine.state');



Route::post('/beginProduction', [ProductionController::class, 'beginProduction'])->name('testSend');
Route::post('/clearButton', [ProductionController::class, 'clearButton']);
Route::post('/abortButton', [ProductionController::class, 'abortButton']);
Route::post('/resetButton', [ProductionController::class, 'resetButton']);
Route::post('/stopButton', [ProductionController::class, 'stopButton']);

Route::get('/startProduction', function (){broadcast(new readState());})->name('startProduction');
//Route::get('/abortButton', function (){broadcast(new abortButton());})->name('abortButton');
//Route::get('/clearButton', function (){broadcast(new clearButton());})->name('clearButton');
//Route::get('/resetButton', function (){broadcast(new resetButton());})->name('resetButton');
//Route::get('/stopButton', function (){broadcast(new stopButton());})->name('stopButton');

