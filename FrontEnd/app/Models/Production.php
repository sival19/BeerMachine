<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Production extends Model
{
    use HasFactory;

    public function productionSensorData(){
        return $this->belongsTo(ProductionSensorData::class);
    }

    public function machine(){
        return $this->belongsTo(Machine::class);
    }

    public function beer(){
        return $this->belongsTo(beer::class);
    }
}
