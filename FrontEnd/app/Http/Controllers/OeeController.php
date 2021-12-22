<?php

namespace App\Http\Controllers;

use App\Models\Oee;
use ArielMejiaDev\LarapexCharts\LarapexChart;


class OeeController extends Controller
{
    public function oee(){

        $label = Oee::all();
        $speeds = $label->where('beer_type', 0)->pluck('speed', 'speed')->values();
        $oee = $label->where('beer_type', 0)->pluck('oee');

        $speeds2 = $label->where('beer_type', 1)->pluck('speed', 'speed')->values();
        $oee2 = $label->where('beer_type', 1)->pluck('oee');

        $speeds3 = $label->where('beer_type', 2)->pluck('speed', 'speed')->values();
        $oee3 = $label->where('beer_type', 2)->pluck('oee');

        $speeds4 = $label->where('beer_type', 3)->pluck('speed', 'speed')->values();
        $oee4 = $label->where('beer_type', 3)->pluck('oee');

        $speeds5 = $label->where('beer_type', 4)->pluck('speed', 'speed')->values();
        $oee5 = $label->where('beer_type', 4)->pluck('oee');

        $speeds6 = $label->where('beer_type', 5)->pluck('speed', 'speed')->values();
        $oee6 = $label->where('beer_type', 5)->pluck('oee');

        $chart = (new LarapexChart)->lineChart()
            ->setTitle('OEE Products per minute Pilsner')
            ->addData('Oee',$oee->toArray())
            ->setXAxis($speeds->toArray());

        $chart2 = (new LarapexChart)->lineChart()
            ->setTitle('OEE Products per minute Wheat')
            ->addData('Oee',$oee2->toArray())
            ->setXAxis($speeds2->toArray());

        $chart3 = (new LarapexChart)->lineChart()
            ->setTitle('OEE Products per minute IPA')
            ->addData('Oee',$oee3->toArray())
            ->setXAxis($speeds3->toArray());

        $chart4 = (new LarapexChart)->lineChart()
            ->setTitle('OEE Products per minute Stout')
            ->addData('Oee',$oee4->toArray())
            ->setXAxis($speeds4->toArray());

        $chart5 = (new LarapexChart)->lineChart()
            ->setTitle('OEE Products per minute Ale')
            ->addData('Oee',$oee5->toArray())
            ->setXAxis($speeds5->toArray());

        $chart6 = (new LarapexChart)->lineChart()
            ->setTitle('OEE Products per minute Alcohol Free')
            ->addData('Oee',$oee6->toArray())
            ->setXAxis($speeds6->toArray());


        return view('oee', compact(['chart', 'chart2','chart3','chart4','chart5','chart6']));
    }
}
