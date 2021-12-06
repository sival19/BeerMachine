<?php

namespace App\Http\Controllers;

use App\Events\startProdEvent;
use App\Models\Production;
use Illuminate\Http\Request;

class ProductionController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        //
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {

    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Production  $production
     * @return \Illuminate\Http\Response
     */
    public function show(Production $production)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\Models\Production  $production
     * @return \Illuminate\Http\Response
     */
    public function edit(Production $production)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Production  $production
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Production $production)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Production  $production
     * @return \Illuminate\Http\Response
     */
    public function destroy(Production $production)
    {
        //
    }


    public function show_productions()
    {
        return view('showProductions');
    }

    public function showCurrentProduction(){

        return view('showCurrentProduction');

    }

    public function show_production()
    {
        return view('showProduction');
    }

    public function beginProduction(Request $request){
        //Validate form inputs
        $validated = $request->validate([
            'machineSpeed' => 'required|numeric|min:1|Integer',
            'amount' => 'required|numeric|min:1|Integer',
            'type' => 'required'
        ]);

        event(new startProdEvent(

            $request->input('type'),
            $request->input('machineSpeed'),
            $request->input('amount'),



            ));
        return back();
    }

    public function test(){
        return view('test');
    }

    public function startProduction()
    {

        return view('startProductionView');
    }
}
