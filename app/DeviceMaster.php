<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class DeviceMaster extends Model
{
    protected $table = 'device_master';
    public $timestamps = false;
    protected $fillable = array(
    	
    	'phone_no',
    	'date_manufactured',
    	'serial_no',
    	'date_updated'
    	
    );

}
