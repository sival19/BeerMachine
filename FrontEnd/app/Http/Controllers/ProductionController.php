<?php

namespace App\Http\Controllers;

use App\Events\abortButton;
use App\Events\clearButton;
use App\Events\resetButton;
use App\Events\startProdEvent;
use App\Events\stopButton;
use App\Models\Production;
use Illuminate\Http\Request;
use Illuminate\Http\Response;

class ProductionController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return Response
     */
    public function index()
    {
        //
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param \Illuminate\Http\Request $request
     * @return Response
     */
    public function store(Request $request)
    {

    }

    /**
     * Display the specified resource.
     *
     * @param \App\Models\Production $production
     * @return Response
     */
    public function show(Production $production)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param \App\Models\Production $production
     * @return Response
     */
    public function edit(Production $production)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param \Illuminate\Http\Request $request
     * @param \App\Models\Production $production
     * @return Response
     */
    public function update(Request $request, Production $production)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param \App\Models\Production $production
     * @return Response
     */
    public function destroy(Production $production)
    {
        //
    }


    public function show_productions()
    {
        return view('showProductions');
    }

    public function showCurrentProduction()
    {

        return view('showCurrentProduction');

    }

    public function show_production()
    {
        return view('showProduction');
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
            amount: $request->input('amount'),
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

    public function test()
    {
        return view('test');
    }

    public function startProduction()
    {

        return view('startProductionView');
    }
}
