<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Devices extends Model
{
    protected $table = 'devices';
    public $timestamps = false;
    protected $fillable = array(
    	
    	'phone_no',
    	'type',
    	'users_id'
    	
    );

}
