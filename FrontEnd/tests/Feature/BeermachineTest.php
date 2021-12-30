<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Tests\TestCase;

class BeermachineTest extends TestCase
{
    /**
     * A basic test example.
     *
     * @return void
     */
    public function test_homepage()
    {
        $response = $this->get('/');
        $response->assertStatus(200);
    }

    public function test_showProductions()
    {
        $response = $this->get('/show_productions');
        $response->assertStatus(200);
        $this->get('/show_productions')->assertViewHas('productions');
    }

//    public function test_production_form()
//    {
//        $response = $this->json('POST',
//            '/startProduction',
//            ['amount' => '100',
//            'machineSpeed' => '100']
//        );
//        $response->assertSessionDoesntHaveErrors();
//    }
}
