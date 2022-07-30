<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">



<title>Mails</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" />

</head>
<body>

	<div class="container">
		<%@ include file="../layouts/header.jsp"%>
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-body bg-primary text-white mailbox-widget pb-0">
						<h2 class="text-white pb-3">Your Mailbox</h2>
						<ul class="nav nav-tabs custom-tab border-bottom-0 mt-4"
							id="myTab" role="tablist">
							<li class="nav-item"><a class="nav-link active"
								id="inbox-tab" data-toggle="tab" aria-controls="inbox"
								href="#inbox" role="tab" aria-selected="true"> <span
									class="d-block d-md-none"><i class="ti-email"></i></span> <span
									class="d-none d-md-block"> INBOX</span>
							</a></li>
							<li class="nav-item"><a class="nav-link" id="sent-tab"
								data-toggle="tab" aria-controls="sent" href="#sent" role="tab"
								aria-selected="false"> <span class="d-block d-md-none"><i
										class="ti-export"></i></span> <span class="d-none d-md-block">SENT</span>
							</a></li>
							<li class="nav-item"><a class="nav-link" id="spam-tab"
								data-toggle="tab" aria-controls="spam" href="#spam" role="tab"
								aria-selected="false"> <span class="d-block d-md-none"><i
										class="ti-panel"></i></span> <span class="d-none d-md-block">SPAM</span>
							</a></li>
							<li class="nav-item"><a class="nav-link" id="delete-tab"
								data-toggle="tab" aria-controls="delete" href="#delete"
								role="tab" aria-selected="false"> <span
									class="d-block d-md-none"><i class="ti-trash"></i></span> <span
									class="d-none d-md-block">DELETED</span>
							</a></li>
						</ul>
					</div>
					<div class="tab-content" id="myTabContent">
						<div class="tab-pane fade active show" id="inbox"
							aria-labelledby="inbox-tab" role="tabpanel">
							<div>
								<div class="row p-4 no-gutters align-items-center">
									<div class="col-sm-12 col-md-6">
										<h3 class="font-light mb-0">
											<i class="ti-email mr-2"></i>350 Unread emails
										</h3>
									</div>
									<div class="col-sm-12 col-md-6">
										<ul class="list-inline dl mb-0 float-left float-md-right">
											<li class="list-inline-item text-info mr-3"><a href="/Ecommerce_Manager_beta/mail/create">
													<button class="btn btn-circle btn-success text-white"
														href="javascript:void(0)">
														<i class="fa fa-plus"></i>
													</button> <span class="ml-2 font-normal text-dark">Compose</span>
											</a></li>
											<li class="list-inline-item text-danger"><a href="#">
													<button class="btn btn-circle btn-danger text-white"
														href="javascript:void(0)">
														<i class="fa fa-trash"></i>
													</button> <span class="ml-2 font-normal text-dark">Delete</span>
											</a></li>
										</ul>
									</div>
								</div>
								<!-- Mail list-->
								<div class="table-responsive">
									<c:if test="${empty inbox }">
										<div class="row p-3 text-dark">
											<div class="col-md-6">
												<h3 class="font-light">no Mails</h3>
											</div>
										</div>
									</c:if>
									<c:if test="${!empty inbox }">
										<table
											class="table email-table no-wrap table-hover v-middle mb-0 font-14">
											<tbody>
												<!-- row -->
												<c:forEach items="${inbox }" var="i">
													<tr>
														<!-- label -->
														<td class="pl-3">
															<div class="custom-control custom-checkbox">
																<input type="checkbox" class="custom-control-input"
																	id="cst1" /> <label class="custom-control-label"
																	for="cst1">&nbsp;</label>
															</div>
														</td>
														<!-- star -->
														<td><i class="fa fa-star text-warning"></i></td>
														<td><span class="mb-0 text-muted">${i.sender.email }</span>
														</td>
														<!-- Message -->
														<td><a class="link" href="/Ecommerce_Manager_beta/mail/details?id=${i.id }"> <span
																class="badge badge-pill text-white font-medium badge-danger mr-2">Work</span>
																<span class="text-dark">${i.subject }</span>
														</a></td>
														<!-- Attachment -->
														<td><i class="fa fa-paperclip text-muted"></i></td>
														<!-- Time -->
														<td class="text-muted">${i.createdAt }</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</c:if>

								</div>
							</div>
						</div>
						<div class="tab-pane fade" id="sent" aria-labelledby="sent-tab"
							role="tabpanel">
						<div class="table-responsive">
									<c:if test="${empty sentmails }">
										<div class="row p-3 text-dark">
											<div class="col-md-6">
												<h3 class="font-light">no Mails</h3>
											</div>
										</div>
									</c:if>
									<c:if test="${!empty sentmails }">
										<table
											class="table email-table no-wrap table-hover v-middle mb-0 font-14">
											<tbody>
												<!-- row -->
												<c:forEach items="${sentmails }" var="s">
													<tr>
														<!-- label -->
														<td class="pl-3">
															<div class="custom-control custom-checkbox">
																<input type="checkbox" class="custom-control-input"
																	id="cst1" /> <label class="custom-control-label"
																	for="cst1">&nbsp;</label>
															</div>
														</td>
														<!-- star -->
														<td><i class="fa fa-star text-warning"></i></td>
														<td><span class="mb-0 text-muted">${s.recipient.email }</span>
														</td>
														<!-- Message -->
														<td><a class="link" href="/Ecommerce_Manager_beta/mail/details?id=${s.id }"> <span
																class="badge badge-pill text-white font-medium badge-danger mr-2">Work</span>
																<span class="text-dark">${s.subject }</span>
														</a></td>
														<!-- Attachment -->
														<td><i class="fa fa-paperclip text-muted"></i></td>
														<!-- Time -->
														<td class="text-muted">${s.createdAt }</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</c:if>

								</div>
						</div>
						<div class="tab-pane fade" id="spam" aria-labelledby="spam-tab"
							role="tabpanel">
							<div class="row p-3 text-dark">
								<div class="col-md-6">
									<h3 class="font-light">Come on you have a lot message</h3>
									<h4 class="font-light">you can use it with the small code</h4>
								</div>
								<div class="col-md-6 text-right">
									<p>Donec pede justo, fringilla vel, aliquet nec, vulputate
										eget, arcu. In enim justo, rhoncus ut, imperdiet a.</p>
								</div>
							</div>
						</div>
						<div class="tab-pane fade" id="delete"
							aria-labelledby="delete-tab" role="tabpanel">
							<div class="row p-3 text-dark">
								<div class="col-md-6">
									<h3 class="font-light">Just do Settings</h3>
									<h4 class="font-light">you can use it with the small code</h4>
								</div>
								<div class="col-md-6 text-right">
									<p>Donec pede justo, fringilla vel, aliquet nec, vulputate
										eget, arcu. In enim justo, rhoncus ut, imperdiet a.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="../layouts/footer.jsp"%>
	</div>


	<style type="text/css">
body {
	background: #edf1f5;
	margin-top: 20px;
}

.card {
	position: relative;
	display: flex;
	flex-direction: column;
	min-width: 0;
	word-wrap: break-word;
	background-color: #fff;
	background-clip: border-box;
	border: 0 solid transparent;
	border-radius: 0;
}

.mailbox-widget .custom-tab .nav-item .nav-link {
	border: 0;
	color: #fff;
	border-bottom: 3px solid transparent;
}

.mailbox-widget .custom-tab .nav-item .nav-link.active {
	background: 0 0;
	color: #fff;
	border-bottom: 3px solid #2cd07e;
}

.no-wrap td, .no-wrap th {
	white-space: nowrap;
}

.table td, .table th {
	padding: .9375rem .4rem;
	vertical-align: top;
	border-top: 1px solid rgba(120, 130, 140, .13);
}

.font-light {
	font-weight: 300;
}
</style>

	<script type="text/javascript">

</script>
</body>
</html>