<?php

namespace App\Http\Controllers;

use App\Events\abortButton;
use App\Events\clearButton;
use App\Events\readState;
use App\Events\resetButton;
use App\Events\startProdEvent;
use App\Events\stopButton;
use App\Models\Machine;
use App\Models\Oee;
use App\Models\Production;
use App\Models\ProductionSensorData;
use ArielMejiaDev\LarapexCharts\LarapexChart;
use Illuminate\Http\Request;
use Illuminate\Http\Response;

class ProductionController extends Controller
{

    public function show_productions()
    {
        $productions = Production::all();
        return view('showProductions', ['productions'=>$productions]);
    }

    public function getProductions()
    {
//        $productions = Production::all()->find();
        $productions = Production::all();

        if (\Illuminate\Support\Facades\Request::ajax()){
            return response() ->json($productions);
        }
    }


    public function show_production($id)
    {
        $labels = ProductionSensorData::all()->where('production_id', $id);
        $tempvalue = $labels->where('type', 'temp')->pluck( 'value','created_at');
        $hummValue = $labels->where('type', 'humm')->pluck( 'value','created_at');
        $labels = ProductionSensorData::pluck('created_at');
        $chart = (new LarapexChart)->lineChart()
            ->setTitle('SensorData')
            ->addData('Temperature',$tempvalue->values()->toArray())
            ->addData('Humidity', $hummValue->values()->toArray())
            ->setXAxis($tempvalue->keys()->toArray());

        $production = Production::find($id);
        return view('showProduction', ['production'=> $production], compact('chart'));
    }

    public function beginProduction(Request $request)
    {
        //Validate form inputs
        $validated = $request->validate([
            'machineSpeed' => 'required|numeric|min:1|Integer',
            'amount' => 'required|numeric|min:1|Integer',
            'type' => 'required'
        ]);
        event(new startProdEvent(
            type: $request->input('type'),
            speed: $request->input('machineSpeed'),
            amount: $request->input('amount')
        ));
        return back();
    }

    public function abortButton(Request $request)
    {
        event(new abortButton($request->input('abortValue')));
        return back();
    }

    public function clearButton(Request $request)
    {
        event(new clearButton($request->input("clearValue")));
        return back();
    }

    public function resetButton(Request $request)
    {
        event(new resetButton($request->input('resetValue')));
        return back();
    }

    public function stopButton(Request $request)
    {
        event(new stopButton($request->input('stopValue')));
        return back();
    }

    public function startProduction()
    {


        event(new readState());
        return view('startProductionView');

    }


    public function getState()
    {
        $status = Machine::all();

        if (\Illuminate\Support\Facades\Request::ajax()){
            return response() ->json($status);
        }
    }
}
