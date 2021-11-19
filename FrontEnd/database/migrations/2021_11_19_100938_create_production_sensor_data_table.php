<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateProductionSensorDataTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('production_sensor_data', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger('production_id');
            $table->timestamps();


            $table->foreign('production_id')->references('id')->on('productions');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('production_sensor_data');
    }
}
