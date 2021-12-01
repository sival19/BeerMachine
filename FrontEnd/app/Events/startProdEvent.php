<?php

namespace App\Events;

use Illuminate\Broadcasting\Channel;
use Illuminate\Broadcasting\InteractsWithSockets;
use Illuminate\Broadcasting\PresenceChannel;
use Illuminate\Broadcasting\PrivateChannel;
use Illuminate\Contracts\Broadcasting\ShouldBroadcast;
use Illuminate\Foundation\Events\Dispatchable;
use Illuminate\Queue\SerializesModels;

class startProdEvent implements ShouldBroadcast
{
    use Dispatchable, InteractsWithSockets, SerializesModels;
    public $type;
    public $speed;
    public $amount;

    /**
     * Create a new event instance.
     *
     * @return void
     */
    public function __construct($type, $speed, $amount)
    {
        $this->type = $type;
        $this->amount = $amount;
        $this->speed = $speed;
    }

    public function broadcastToEveryone()
    {


    }

//    public function broadcastWith(){
//        return ['1' => '2'];
//    }


    /**
     * Get the channels the event should broadcast on.
     *
     * @return \Illuminate\Broadcasting\Channel|array
     */
    public function broadcastOn()
    {

        return new Channel('my-channel');
    }
}
