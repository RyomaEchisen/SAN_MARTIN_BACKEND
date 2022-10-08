package com.san.martin.auth;

public class JwtConfig {
	public static final String LLAVE_SECRETA ="alguna.clave.secreta.12345678";
    
	public static final String RSA_PRIVADA="-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEpAIBAAKCAQEA1fEbFdJ0AXYfCprlCplAcdRgIh++nSJT+WcPlmQtEx7VJy7r\r\n"
			+ "67Y7Pgxlmm5fDoA3QOQG9DX0Pbv4KNpLZmdCLkP9DZ06bGB2E013SpzzzQSl12h2\r\n"
			+ "eP7BHvGiGO0MOEjeJyCGENZVvOrJXl5eCNYsRzqFWsUlvq1K6CcwjPEzfbixXamy\r\n"
			+ "JUJweMy5OZuVas8MenTw+zhBZEtKAlSKYj0aipHgM39PRNBkW3XZJRwh+wFoIWYt\r\n"
			+ "z8HqfGUyUsAgIAY7fml3TO5UFvr7NmRR8BYoctp8Pg3/tQtt4AaBiVJBMYMMsCth\r\n"
			+ "v7XQQ9lKPZQEeTVh04QQ2de2PfnKkRFVgsDlEQIDAQABAoIBAQDKTCxCXDgZUapU\r\n"
			+ "itbdSMBpYlpsqfvB9b3V7SAOIzeEBvmjDXlD75LhPzOr7YWw3ohgsb3pmkMTRPSJ\r\n"
			+ "HLGDaUxpFxznjK674BKGeg+82+ClEioHH9421x2htvaB/1Q4vJ5j/RsIPMPh2VkE\r\n"
			+ "BNOCI5LG341NoXHpdU+JadU80K7RxuDW5wE/ayXkJIH1oik61KtiTEzv/jmmGuFL\r\n"
			+ "lQNW/tCybySOPNlEycdV/qnDbpSsXeblKt0WaypgQ5duXJFY9BycpQdxp/FWfw8o\r\n"
			+ "SzNtaUzBS9jjvH2la47gpf+TmIBhDMm3xCwYBdrlkV0SCr8QcwI1cYq6Cc4AWWUT\r\n"
			+ "FxOhW9gJAoGBAP29+Rg0R/5bupScrMyNYYJO2HvGlzkA59F6bkkHXDpBNeZnRRMF\r\n"
			+ "LdOWdUfyGh8RJ5SE3EA5TID8/iYkbhPhbHf5qXAoxiSP4FPOY2INjoGVvpUtvweG\r\n"
			+ "FyiSFmIBW1fJRRAbh4u7VZyZj+fkZLZ0BsqVybXqwDDHDE2HC2+EKVdnAoGBANfY\r\n"
			+ "d6Z7O+ivcrv/ijtU7CnH+NSygUh75EMn8UxAq6c3ICVmM6TuLuvAlxx48d3rmZ3t\r\n"
			+ "rnY8qEDolCbEuRwoxCh+jhd0uywBnMIP9i5V1QzU5N5ELiWXklsVF2ROYsgFpWhw\r\n"
			+ "hucghD7SRAT7NF+DrIKZwpVhqv++EQjBwy3lvezHAoGAVjFQCi7IPdj++jh2Yk2s\r\n"
			+ "T81ksDb3a3+pP3ktOVVsuMUqAAgYaKubs4IqeLP+t4rmPQccohxUpoRJ+L7rPYmX\r\n"
			+ "hPGj4tuW4xiUhSNYkxgzzkUFpjsR5wZfm4J0Y/o+AwX1ldEkLA0IuddYENd+dpPX\r\n"
			+ "Mr3K9Sa2/lq/DR7QfaMRQAUCgYEAiT47viCnlClS09UFSPqTe3GKd3vVFoioOEdC\r\n"
			+ "d5C7VISJrR4SAnHsZby8mL8SU2BF+hQyFT42YadA5HG7nfsR1wm5QZLYnH+d9AsA\r\n"
			+ "JrAu2ozXxbgme4Kn7cA4cnAhATwN052ROY8EZ4l89Inh4EWyQAySnDdQ6nIpFJ9X\r\n"
			+ "gmyNWesCgYA8XBx1MTC6QPAK0IRmWKhBLfhPcb7wFUPdklZ35N1BfaLOQDJAWCE7\r\n"
			+ "iHoQy0RboOfOsOkMzAvKf3+MwV29JvbSzn7pT2wbtCgDlr2n2L3BgNptQr4Gi4Bm\r\n"
			+ "V62f8OyTdgeVMaZaM8X2F1WDA3oFC2RAcqHO33m2GFSn60/DQBLk3g==\r\n"
			+ "-----END RSA PRIVATE KEY-----";
	public static final String RSA_PUBLICA="-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1fEbFdJ0AXYfCprlCplA\r\n"
			+ "cdRgIh++nSJT+WcPlmQtEx7VJy7r67Y7Pgxlmm5fDoA3QOQG9DX0Pbv4KNpLZmdC\r\n"
			+ "LkP9DZ06bGB2E013SpzzzQSl12h2eP7BHvGiGO0MOEjeJyCGENZVvOrJXl5eCNYs\r\n"
			+ "RzqFWsUlvq1K6CcwjPEzfbixXamyJUJweMy5OZuVas8MenTw+zhBZEtKAlSKYj0a\r\n"
			+ "ipHgM39PRNBkW3XZJRwh+wFoIWYtz8HqfGUyUsAgIAY7fml3TO5UFvr7NmRR8BYo\r\n"
			+ "ctp8Pg3/tQtt4AaBiVJBMYMMsCthv7XQQ9lKPZQEeTVh04QQ2de2PfnKkRFVgsDl\r\n"
			+ "EQIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";
}
