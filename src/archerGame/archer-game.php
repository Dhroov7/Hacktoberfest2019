<?php
	class Dice {
		public function play($players, $round) 
		{
			$abc 	= array('A', 'B', 'C', 'D');
			$temp 	= array();
			
			echo '<h1>Round '.$round.'</h1>';
			echo '<pre>';
			print_r( $players ); // Print after dice rolled
			echo '<hr />';
			$result = array();

			// Foreach to Search the number 1, in top
			foreach ($players as $ply => $val) 
			{
				$key = array_search($ply, $abc);
				if($players[$ply][0] == 1)
				{
					if($key == 3)
					{
						if( isset($players['A']) )
						{
							$keyName = 'A';
						}
						elseif ( isset($players['B']) ) 
						{
							$keyName = 'B';
						}
						elseif ( isset($players['C']) ) 
						{
							$keyName = 'C';
						}
					}
					else
					{
						if( isset($players[ $abc[$key + 1] ]) )
						{
							$keyName = $abc[$key + 1];
						}
						elseif ( isset($players[ $abc[$key + 2] ]) ) 
						{
							$keyName = $abc[$key + 2];
						}
					}

					if ( isset($keyName) )
					{
						$players[$keyName][] 	= 1;
						$result[$keyName][] 	= rand(1, 6);
					}
					unset($players[$ply][0]);
				}
			}

			// Foreach to Search the number 6
			foreach ($players as $ply => $val) 
			{
				foreach($players[$ply] as $v)
				{
					if($v != 6)
					{
						$temp[$ply][] 		= $v;
						$result[$ply][] 	= rand(1, 6);
					}
				}
			}

			echo '<h1>Result</h1>';
			echo '<pre>';
			print_r( $temp ); // Print adter dice moved/removed
			echo '<hr/>';

			$ress = '';
			foreach ($abc as $v) 
			{
				if( !isset( $temp[$v] ) )
				{
					if(empty($ress))
					{
						$ress .= $v. ' WIN';
					}
					else
					{
						$ress .= ' And ' . $v. ' WIN';
					}
				}
			}

			if(!empty($ress))
			{
				echo $ress;
				exit();
			}
			else
			{
				$this->play($result, ($round + 1) );
				exit();
			}
		}
	}


	$players = array();
	$players['A'] = array( rand(1,6), rand(1,6), rand(1,6), rand(1,6), rand(1,6), rand(1,6) );
	$players['B'] = array( rand(1,6), rand(1,6), rand(1,6), rand(1,6), rand(1,6), rand(1,6) );
	$players['C'] = array( rand(1,6), rand(1,6), rand(1,6), rand(1,6), rand(1,6), rand(1,6) );
	$players['D'] = array( rand(1,6), rand(1,6), rand(1,6), rand(1,6), rand(1,6), rand(1,6) );

	$dice = new Dice();
	$dice->play($players, 1);
?>